# java-loggers-samples
Java Logger Samples (java.util.logging, slf4j + logback-classic)

```
$ mvn package

jul-default-demo, jul-create-logger, loback-*:
$ java -jar target/*.jar

jul-globalconf-byfile:
$ java -Djava.util.logging.config.file=demo.prop -jar target/*.jar

jul-globalconf-byclass:
$ java -Djava.util.logging.config.class=testpkg.Main -jar target/*.jar
```

## サンプルの説明

 * jul-default-demo
   * java.util.logging の基本的な使い方を試すサンプル
 * jul-globalconf-byfile
   * java.util.logging で `-Djava.util.logging.config.file=プロパティファイル` による設定のサンプル
 * jul-globalconf-byclass
   * java.util.logging で `-Djava.util.logging.config.class=設定クラス` による設定のサンプル
 * jul-create-logger
   * 動的に java.util.logging の Logger を作成するサンプル
 * logback-conf-xml
   * slf4j + logback-classic で、logback.xml による設定のサンプル
 * logback-conf-groovy
   * slf4j + logback-classic で、logback.groovy による設定のサンプル
 * logback-create-logger
   * slf4j + logback-classic で、logback-classic の Logger を動的に設定するサンプル
 * logback-sift-demo
   * slf4j の MDC (Mapped Diagnostic Context) と logback-classic の `SiftingAppender` を使って、一つのLoggerでMDCを切り替えて複数のファイルにロギングするサンプル

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

## 参考URL (slf4j + logbackの公式サイト他)

 * SLF4J
   * http://www.slf4j.org/
 * Logback Home
   * http://logback.qos.ch/
 * コピペで始めるSLF4J & Logback ｜ Developers.IO
   * http://dev.classmethod.jp/server-side/java/slf4j-logback/
 * Logback 使い方メモ - Qiita
   * http://qiita.com/opengl-8080/items/49719f2d35171f017aa9

## 参考URL (logbackのLoggerの動的生成)

もともとマルチスレッドで複数のエージェント処理を行わせる時に、それぞれのエージェント用のLoggerを動的に設定したい（＝ログファイルをエージェントごとに動的に用意したい）ために調べてみた。
ただし、結論としては動的な生成は難易度が高い（長期間実行される場合、生成したLoggerを破棄する処理も考えないといけないため、logbackの内部実装の知識が必要となってくるため、学習コストが高い）。
SiftingAppender を使ったほうがslf4j + logbackの流儀の範囲内で、エージェントごとにログファイルを分けられるので、こちらを優先して検討したい。

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

## 参考URL (logbackのSiftingAppenderの使い方)

一つのLoggerで、MDCや他の情報ソースを使ってログファイルを分離したい場合などに、logbackのSiftingAppenderを検討したい。

 * Chapter 4: Appenders , SiftingAppender
   * http://logback.qos.ch/manual/appenders.html#SiftingAppender
 * Logback – different log file for each thread
   * http://www.mkyong.com/logging/logback-different-log-file-for-each-thread/
 * Logback - how to get each logger logging to a seperate log file? - Stack Overflow
   * http://stackoverflow.com/questions/18187657/logback-how-to-get-each-logger-logging-to-a-seperate-log-file

## その他の参考URLメモ

### ログのパフォーマンス系

 * Benchmarking Java Logging Frameworks
   * https://www.loggly.com/blog/benchmarking-java-logging-frameworks/
 * Java logging performance pitfalls - Java Performance Tuning Guide
   * http://java-performance.info/java-logging-performance/
 * マルチスレッド下におけるログ出力性能測定 - torutkの日記
   * http://d.hatena.ne.jp/torutk/20110415/p1

### slf4jのブリッジ系

 * Javaのロガーの種類が多すぎ、一元化したい - Qiita
   * http://qiita.com/k_ui/items/7ed7d9f9c15dc9bcc26f
 * kui/logger-integration-sample: java のロガー多すぎるので、一元化がするための設定サンプル
   * https://github.com/kui/logger-integration-sample
 * コピペで始めるSLF4J & Logback ｜ Developers.IO
   * http://dev.classmethod.jp/server-side/java/slf4j-logback/
