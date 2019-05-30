# SkynetEye配置：
#########SpringBoot整合Redis，使用的是RedisTemplate，分别实现了SpringBoot与redis的单机版、集群版、哨兵模式的整合。
spring.redis.host=localhost
spring.redis.password=battcn
# 连接超时时间（毫秒）
spring.redis.timeout=10000
# Redis默认情况下有16个分片，这里配置具体使用的分片，默认是0
spring.redis.database=0
# 连接池最大连接数（使用负值表示没有限制） 默认 8
spring.redis.lettuce.pool.max-active=8
# 连接池最大阻塞等待时间（使用负值表示没有限制） 默认 -1
spring.redis.lettuce.pool.max-wait=-1
# 连接池中的最大空闲连接 默认 8
spring.redis.lettuce.pool.max-idle=8
# 连接池中的最小空闲连接 默认 0
spring.redis.lettuce.pool.min-idle=0

###################################################################################
#Matser的ip地址  
redis.hostName=192.168.177.128
#端口号  
redis.port=6382
#如果有密码  
redis.password=
#客户端超时时间单位是毫秒 默认是2000 
redis.timeout=10000  

#最大空闲数  
redis.maxIdle=300  
#连接池的最大数据库连接数。设为0表示无限制,如果是jedis 2.4以后用redis.maxTotal  
#redis.maxActive=600  
#控制一个pool可分配多少个jedis实例,用来替换上面的redis.maxActive,如果是jedis 2.4以后用该属性  
redis.maxTotal=1000  
#最大建立连接等待时间。如果超过此时间将接到异常。设为-1表示无限制。  
redis.maxWaitMillis=1000  
#连接的最小空闲时间 默认1800000毫秒(30分钟)  
redis.minEvictableIdleTimeMillis=300000  
#每次释放连接的最大数目,默认3  
redis.numTestsPerEvictionRun=1024  
#逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1  
redis.timeBetweenEvictionRunsMillis=30000  
#是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个  
redis.testOnBorrow=true  
#在空闲时检查有效性, 默认false  
redis.testWhileIdle=true  

#redis集群配置      
spring.redis.cluster.nodes=192.168.177.128:7001,192.168.177.128:7002,192.168.177.128:7003,192.168.177.128:7004,192.168.177.128:7005,192.168.177.128:7006
spring.redis.cluster.max-redirects=3

#哨兵模式
#redis.sentinel.host1=192.168.177.128
#redis.sentinel.port1=26379

#redis.sentinel.host2=172.20.1.231  
#redis.sentinel.port2=26379