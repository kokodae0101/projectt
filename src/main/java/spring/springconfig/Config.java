package spring.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration//набор параметров и настроек
@EnableWebMvc//для включения поддержки веб-модели MVC
@EnableTransactionManagement//используется для вкулючения управления трапзакциями
@ComponentScan("spring")// для автоматического поиска и регистрации компонентов в контексте приложения

public class Config implements WebMvcConfigurer {
    @Bean//оббект
    public DataSource date () {
        DriverManagerDataSource data = new DriverManagerDataSource();
        data.setDriverClassName("org.postgresql.Driver");
        data.setUrl("jdbc:postgresql://localhost:5432/postgres");
        data.setUsername("postgres");
        data.setPassword("root");
        return data;
    }

    @Bean
    public LocalSessionFactoryBean loc() {
        LocalSessionFactoryBean loca = new LocalSessionFactoryBean();
        loca.setDataSource(date());
        loca.setPackagesToScan(new String[]{"spring.model"});
        return loca;
    }


    @Bean
    public HibernateTransactionManager man() {
        HibernateTransactionManager mane = new HibernateTransactionManager();
        mane.setSessionFactory(loc().getObject());
        return mane;
    }

    public void configureViewResolvers(ViewResolverRegistry view) {
        InternalResourceViewResolver inter = new InternalResourceViewResolver();
        inter.setPrefix("/WEB-INF/view/");
        inter.setSuffix(".jsp");
        view.viewResolver(inter);

    }
}
