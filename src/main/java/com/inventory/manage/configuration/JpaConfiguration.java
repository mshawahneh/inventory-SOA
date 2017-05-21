/**
 * 
 */
package com.inventory.manage.configuration;

/**
 * @author mshawahn
 *
 */
//@Configuration
//@EnableJpaRepositories(basePackages = "com.inventory.manage.repositories",
//		entityManagerFactoryRef = "entityManagerFactory",
//		transactionManagerRef = "transactionManager")
//@EnableTransactionManagement
public class JpaConfiguration {
//	@Autowired
//	private Environment environment;
//
//	@Value("${datasource.paymentapp.maxPoolSize:10}")
//	private int maxPoolSize;
//
//	private static final Log logger = LogFactory.getLog(JpaConfiguration.class);
//	/*
//	 * Populate SpringBoot DataSourceProperties object directly from application.yml 
//	 */
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix = "datasource.inventoryapp")
//	public DataSourceProperties dataSourceProperties(){
//		return new DataSourceProperties();
//	}
//
//	/*
//	 * Configure HikariCP pooled DataSource.
//	 */
//	@Bean
//	public DataSource dataSource() {
//		logger.info("dataSource method");
//		DataSourceProperties dataSourceProperties = dataSourceProperties();
//			HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder
//					.create(dataSourceProperties.getClassLoader())
//					.driverClassName(dataSourceProperties.getDriverClassName())
//					.url(dataSourceProperties.getUrl())
//					.username(dataSourceProperties.getUsername())
//					.password(dataSourceProperties.getPassword())
//					.type(HikariDataSource.class)
//					.build();
//			dataSource.setMaximumPoolSize(maxPoolSize);
//			return dataSource;
//	}
//
//	/*
//	 * Entity Manager Factory setup.
//	 */
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
//		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
////		factoryBean.setDataSource(dataSource());
//		factoryBean.setPackagesToScan(new String[] { "com.inventory.manage.model" });
////		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
////		factoryBean.setJpaProperties(jpaProperties());
//		return factoryBean;
//	}
//
//	/*
//	 * Provider specific adapter.
//	 */
//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter() {
//		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//		return hibernateJpaVendorAdapter;
//	}
//
//	/*
//	 * Here you can specify any provider specific properties.
//	 */
//	private Properties jpaProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", environment.getRequiredProperty("datasource.inventoryapp.hibernate.dialect"));
//		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("datasource.inventoryapp.hibernate.hbm2ddl.method"));
//		properties.put("hibernate.show_sql", environment.getRequiredProperty("datasource.inventoryapp.hibernate.show_sql"));
//		properties.put("hibernate.format_sql", environment.getRequiredProperty("datasource.inventoryapp.hibernate.format_sql"));
//		if(StringUtils.isNotEmpty(environment.getRequiredProperty("datasource.inventoryapp.defaultSchema"))){
//			properties.put("hibernate.default_schema", environment.getRequiredProperty("datasource.inventoryapp.defaultSchema"));
//		}
//		return properties;
//	}
//
//	@Bean
//	@Autowired
//	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(emf);
//		return txManager;
//	}
}
