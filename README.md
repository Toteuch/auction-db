# auction-db

Put application.properties file into "config" folder right beside compiled jar

application.properties :
spring.datasource.url=                                             #JDBC URI (postgres)
spring.datasource.platform=postgres
spring.datasource.username=                                        #Postgres username
spring.datasource.password=                                        #Postgres password

spring.jpa.hibernate.ddl-auto=none                                 #or update if you want ddl to be updated according to entites

auctiondb.blizzard.api.username=                                   #Your Blizzard API Username
auctiondb.blizzard.api.secret=                                     #Your Blizzard API Secret

logging.level.root=INFO
logging.level.com.toteuch.auctiondb.services=DEBUG
auctiondb.jobs.enabled=true                                        #true if not present