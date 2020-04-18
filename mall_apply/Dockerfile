FROM	sidereal/jre8

MAINTAINER yaqiwe 15338230927@163.com

ADD ./target/mall_apply-0.0.1-SNAPSHOT.jar mall_apply.jar

EXPOSE 8080

ENTRYPOINT java -jar mall_apply.jar -Dspring.profiles.active=user,common,commodity,prod

