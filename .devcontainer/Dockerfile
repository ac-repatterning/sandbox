# Base
FROM spark:3.5.7-scala2.12-java17-ubuntu


# User `root`; remote development stage only.
USER root


# Arguments
ARG SCALA_VERSION=2.12.18
ARG SCALA_ARCHIVE_NAME=scala-${SCALA_VERSION}
ARG SCALA_URL=https://downloads.lightbend.com/scala/${SCALA_VERSION}/${SCALA_ARCHIVE_NAME}.tgz

ARG SBT_VERSION=1.12.1
ARG SBT_ARCHIVE_NAME=sbt-$SBT_VERSION
ARG SBT_URL=https://github.com/sbt/sbt/releases/download/v${SBT_VERSION}/${SBT_ARCHIVE_NAME}.tgz

ARG HADOOP_VERSION=3.4.2
ARG HADOOP_ARCHIVE_NAME=hadoop-${HADOOP_VERSION}
ARG HADOOP_URL=https://www.apache.org/dyn/closer.cgi/hadoop/common/hadoop-${HADOOP_VERSION}/${HADOOP_ARCHIVE_NAME}.tar.gz


# Setting-up
RUN apt update && apt -q -y upgrade && apt install sudo && \
    apt -y install graphviz && apt -y install vim && \
    apt -y install unzip && \
    apt -y install build-essential && \
    curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "/tmp/awscliv2.zip" && \
    unzip /tmp/awscliv2.zip -d /tmp/ && cd /tmp && sudo ./aws/install && cd ~ && \
    wget -q ${SCALA_URL} && tar -zxvf ${SCALA_ARCHIVE_NAME}.tgz && cp -R ${SCALA_ARCHIVE_NAME} /opt/scala && rm -R scala* && \
    wget -q ${SBT_URL} && tar -zxvf ${SBT_ARCHIVE_NAME}.tgz && cp -R sbt /opt/sbt && rm -R sbt* && \
    wget -q ${HADOOP_URL} && tar zxf ${HADOOP_ARCHIVE_NAME}.tar.gz && cp -R ${HADOOP_ARCHIVE_NAME} /opt/hadoop && rm -R hadoop*


# Environment Variables
ENV SCALA_HOME=/opt/scala
ENV SBT_HOME=/opt/sbt
ENV SPARK_HOME=/opt/spark
ENV HADOOP_HOME=/opt/hadoop
ENV PATH=$JAVA_HOME/bin:$SCALA_HOME/bin:$SBT_HOME/bin:$SPARK_HOME/bin:$SPARK_HOME/sbin:$HADOOP_HOME/bin:$PATH


# If the steps of a `Dockerfile` use files that are different from the `context` file, COPY the
# file of each step separately; and RUN the file immediately after COPY
WORKDIR /root


# Expose ports for monitoring.
# SparkContext web UI on 4040 -- only available for the duration of the application.
# Spark master’s web UI on 8080.
# Spark worker web UI on 8081.
EXPOSE 4040 8080 8081


# ENTRYPOINT
CMD ["/bin/bash"]
