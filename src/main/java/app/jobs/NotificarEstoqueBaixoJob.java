/**
 * As alterações neste arquivo podem causar um comportamento incorreto e serão
 * perdidas se a IDE precisar atualizá-lo
 */
package app.jobs;

import cronapi.database.TransactionManager;
import cronapp.framework.scheduler.SchedulerConfigurer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import cronapi.Var;

/**
 * Tarefa Agendada Notificar Estoque Baixo
 *
 * Notifica Administrador sobre Estoque Baixo
 */
@Component
@DisallowConcurrentExecution
public class NotificarEstoqueBaixoJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      //Verifica Estoque
      blockly.product.VerifyAmount.verifyOnDB();
      TransactionManager.commit();
    } catch (Exception e) {
      TransactionManager.rollback();
      throw new JobExecutionException(e);
    } finally {
      TransactionManager.close();
      TransactionManager.clear();
    }
  }

  @Bean(name = "notificarEstoqueBaixoJobDetail")
  public JobDetailFactoryBean notificarEstoqueBaixoJobDetail() {
    return SchedulerConfigurer.createJobDetail(this.getClass());
  }

  /**
   * Todo dia, 7am
   * Às 07:00
   */
  @Bean(name = "notificarEstoqueBaixoJobTodoDia7amTrigger")
  public CronTriggerFactoryBean notificarEstoqueBaixoJobTodoDia7amTrigger(@Qualifier("notificarEstoqueBaixoJobDetail") JobDetail jobDetail) {

    return SchedulerConfigurer.createCronTrigger(jobDetail, "0 0 7 */1 * ?");
  }
}