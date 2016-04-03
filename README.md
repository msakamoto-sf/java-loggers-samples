# java-loggers-samples
Java Logger Samples (java.util.logging, slf4j + logback-classic)

```
$ mvn package

jul-default-demo:
$ java -jar target/*.jar

jul-globalconf-byfile:
$ java -Djava.util.logging.config.file=demo.prop -jar target/*.jar

jul-globalconf-byclass:
$ java -Djava.util.logging.config.class=testpkg.Main -jar target/*.jar

jul-create-logger:
$ java -jar target/*.jar
```

## 参考URL (java.util.logging)

 * 今日のAPI: java.util.logging (ブログ: 岡崎 - Okazaki's blog)
   * https://blogs.oracle.com/okazaki/entry/%E4%BB%8A%E6%97%A5%E3%81%AEapi_java_util_logging1
 * JavaロギングAPIの拡張機能
   * https://docs.oracle.com/javase/jp/8/docs/technotes/guides/logging/index.html
 * Javaロギングの概要
   * https://docs.oracle.com/javase/jp/8/docs/technotes/guides/logging/overview.html
 * やっとわかった、java.util.logging – Akira Koyasu's WebLog
   * http://www.akirakoyasu.net/2011/11/06/finally-understood-java-util-logging/
 * Java Logging API
   * http://www.02.246.ne.jp/~torutk/javahow2/logging.html#doc1_id19
 * Javaでログ出力(ytp.ne.jp)
   * http://www.ytp.ne.jp/tech/java/sineruka/loggingproperties.html#5
 * Java標準ロギング - ソフトウェアエンジニアリング - Torutk
   * http://www.torutk.com/projects/swe/wiki/Java%E6%A8%99%E6%BA%96%E3%83%AD%E3%82%AE%E3%83%B3%E3%82%B0
 * java.util.loggingの闇 - nekop's blog
   * http://nekop.hatenablog.com/entry/2015/01/15/174649
 * javaのロガーが多すぎて訳が解らないので整理してみました - 文系プログラマによるTIPSブログ
   * http://www.bunkei-programmer.net/entry/2012/10/20/java%E3%81%AE%E3%83%AD%E3%82%AC%E3%83%BC%E3%81%8C%E5%A4%9A%E3%81%99%E3%81%8E%E3%81%A6%E8%A8%B3%E3%81%8C%E8%A7%A3%E3%82%89%E3%81%AA%E3%81%84%E3%81%AE%E3%81%A7%E6%95%B4%E7%90%86%E3%81%97%E3%81%A6
 * Java EE環境でjava.util.loggingとうまく付き合う方法 | Nishigaya's Tech Blog
   * http://javaflavor.hopto.org/blog/2012/12/21/java-ee-and-java-util-logging/

## 参考URL (logbackのLoggerの動的生成)

 * java - SLF4J - Logback: How to configure loggers in runtime? - Stack Overflow
   * http://stackoverflow.com/questions/5448673/slf4j-logback-how-to-configure-loggers-in-runtime
 * java - Configuring Log4j Loggers Programmatically - Stack Overflow
   * http://stackoverflow.com/questions/8965946/configuring-log4j-loggers-programmatically
 * java - Programmatically configure LogBack appender - Stack Overflow
   * http://stackoverflow.com/questions/16910955/programmatically-configure-logback-appender
 * java - Dynamically Create Logback Loggers and Appenders - Stack Overflow
   * http://stackoverflow.com/questions/16845067/dynamically-create-logback-loggers-and-appenders
 * Programmatic configuration of slf4j/logback | Andrey Hihlovskiy
   * https://akhikhl.wordpress.com/2013/07/11/programmatic-configuration-of-slf4jlogback/

