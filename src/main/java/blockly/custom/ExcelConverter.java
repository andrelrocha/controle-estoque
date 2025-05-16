package blockly.custom;

import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;
import cronapi.Var;
import cronapi.CronapiMetaData.CategoryType;
import cronapi.CronapiMetaData.ObjectType;
import cronapi.rest.security.CronappSecurity;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.*;

/**
 * Classe que contém métodos utilitários para conversão de arquivos Excel em listas de objetos.
 * 
 * @author 
 * @version 1.0
 * @since 2025-05-15
 */
@CronapiMetaData(categoryName = "Excel Utils", category = CronapiMetaData.CategoryType.CONVERSION)
@CronappSecurity
public class ExcelConverter {

    /**
     * Converte um arquivo Excel em uma lista de objetos, mapeando as colunas conforme os campos fornecidos.
     *
     * @param excelFile Arquivo Excel no formato Var (esperado como InputStream).
     * @param fieldNames Lista de nomes de campos para mapear as colunas do Excel.
     * @return Lista de objetos representando as linhas do Excel.
     */
    @CronapiMetaData(type = "function", name = "converterExcelParaLista", nameTags = "converter excel", returnType = ObjectType.OBJECT)
    public static Var converterExcelParaLista(
            @ParamMetaData(type = ObjectType.OBJECT, description = "Arquivo Excel") Var excelFile,
            @ParamMetaData(type = ObjectType.OBJECT, description = "Lista de campos") Var fieldNames) {

        List<Map<String, Object>> resultList = new ArrayList<>();

        try (InputStream inputStream = new java.io.ByteArrayInputStream(excelFile.getObjectAsByteArray());
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Pula o cabeçalho
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, Object> obj = new HashMap<>();
                for (int j = 0; j < fieldNames.size(); j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    obj.put(fieldNames.get(j).toString(), getCellValue(cell));
                }
                resultList.add(obj);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o arquivo Excel", e);
        }

        return Var.valueOf(resultList);
    }

    /**
     * Obtém o valor de uma célula do Excel, tratando diferentes tipos de dados.
     *
     * @param cell Célula do Excel.
     * @return Valor da célula como Object.
     */
    private static Object getCellValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> DateUtil.isCellDateFormatted(cell) ? cell.getDateCellValue() : cell.getNumericCellValue();
            case BOOLEAN -> cell.getBooleanCellValue();
            case FORMULA -> cell.getCellFormula();
            case BLANK -> "";
            default -> null;
        };
    }
}
