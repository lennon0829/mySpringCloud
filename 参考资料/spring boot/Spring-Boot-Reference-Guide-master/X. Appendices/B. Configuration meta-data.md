### 附录B. 配置元数据

Spring Boot jars包含元数据文件，它们提供了所有支持的配置属性详情。这些文件设计用于让IDE开发者能够为使用`application.properties`或`application.yml`文件的用户提供上下文帮助及代码完成功能。


主要的元数据文件是在编译器通过处理所有被`@ConfigurationProperties`注解的节点来自动生成的。
