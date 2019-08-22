package cc.yuerblog.sb.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "cc.yuerblog.sb.mapper.articledb", sqlSessionTemplateRef = "articledbSqlSessionTemplate")
public class ArticleDBConfig {
    @Bean(name = "articledbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.articledb")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "articledbSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("articledbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "articledbTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("articledbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "articledbSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("articledbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}