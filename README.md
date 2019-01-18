# data-import
现有一个文本文件，每行为一条用户记录（5000W+），请以最快的速度将其导入 MySQL 数据库。
完成了数据库相关配置，在 ide 中运行 DataImportApplication 的 main 函数，启动应用程序。在应用成功启动后，查看 MySQL 中的 dbdataimport 数据库，会发现新增两个表：

表名	含义
flywayschemahistory	Flyway 执行记录表，记录 Flyway 所执行的 SQL 语句
tb_user	V1.001_createuser.sql 文件的执行结果
Spring Boot 对 Flyway 进行了集成，在应用启动时，会触发 flyway.migrate 的执行，而 Flyway 会自动执行 db/migration 目录下的 SQL 语句，并将结果记录在 flywayschemahistory 表中。

如果，看到这两张表，说明成功完成了数据库的配置。

##关于集合插入对象的引用问题
```java
    List list1;
    List list2;
    list1.add(list2);
    如果list2 = new List();
    list1 最后其实是空的;
    这个是值引用和对象引用的问题;
```