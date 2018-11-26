. 项目名称:离线数据分析平台
. 主要木块:
. 主要技术： 1) 日志收集 ：nginx+flume;jssdk编写  
	      2) 数据处理：hadoop,zookeeper,hbase,hive,sqoop,oozie
	      3) 数据展示：ssm +highcharts
.nginx日志配置信息：	
	log_format  main  '$remote_addr^A$msec^A$http_host^A$request_uri'; 
	192.168.174.1^A1540535404.984^Ahadoop-senior.ibeifeng.com^A/BfImg.gif
	
bin/flume-ng agent -c conf -n a1 -f conf/collectData.conf -Dflume.root.logger=DEBUG,console
bin/hadoop jar jars/transformer-0.0.1.jar com.beifeng.transformer.service.rpc.server.DimensionConverterServer > dcs.log 2>&1 &


collectData.conf:

a1.sources = r1
a1.channels = c1
a1.sinks = k1

## common
a1.sources.r1.channels = c1
a1.sinks.k1.channel = c1

## sources config
a1.sources.r1.type  = exec
a1.sources.r1.command = tail -F /usr/local/nginx/logs/access.log

## channels config
a1.channels.c1.type = memory
a1.channels.c1.capacity = 1000
a1.channels.c1.transactionCapacity = 1000
a1.channels.c1.byteCapacityBufferPercentage = 20
a1.channels.c1.byteCapacity = 1000000
a1.channels.c1.keep-alive = 60

#sinks config
a1.sinks.k1.type = hdfs
a1.sinks.k1.channel = c1
a1.sinks.k1.hdfs.path = hdfs://hadoop-senior.ibeifeng.com:8020/logs/%m/%d
a1.sinks.k1.hdfs.fileType = DataStream
a1.sinks.k1.hdfs.filePrefix = BF-%H
a1.sinks.k1.hdfs.fileSuffix=.log
a1.sinks.k1.hdfs.minBlockReplicas=1
a1.sinks.k1.hdfs.rollInterval=3600
a1.sinks.k1.hdfs.rollSize=132692539
a1.sinks.k1.hdfs.idleTimeout=10
a1.sinks.k1.hdfs.batchSize = 1
a1.sinks.k1.hdfs.rollCount=0
a1.sinks.k1.hdfs.round = true
a1.sinks.k1.hdfs.roundValue = 2
a1.sinks.k1.hdfs.roundUnit = minute
a1.sinks.k1.hdfs.useLocalTimeStamp = true	
====================================================================================================
编写程序：
第一步将收集到的日志数据存储到hbase表中。rowkey设计规则为：








 