FROM spark:latest

USER root
# RUN apt-get update && apt-get install -y supervisor
RUN apt-get update && apt-get install -y nano htop
USER spark

EXPOSE 4040 7077 8080 8081

COPY run.sh /opt/
COPY conf /opt/spark/conf

CMD [ "/opt/run.sh" ]


# 4040: Spark Web UI
# 7077: Spark Master
# 8080: Master Web UI
# 8081: Worker Web UI


# sbin/start-master.sh - Starts a master instance on the machine the script is executed on.
# sbin/start-workers.sh - Starts a worker instance on each machine specified in the conf/workers file.
# sbin/start-worker.sh - Starts a worker instance on the machine the script is executed on.
# sbin/start-connect-server.sh - Starts a Spark Connect server on the machine the script is executed on.
# sbin/start-all.sh - Starts both a master and a number of workers as described above.
# sbin/stop-master.sh - Stops the master that was started via the sbin/start-master.sh script.
# sbin/stop-worker.sh - Stops all worker instances on the machine the script is executed on.
# sbin/stop-workers.sh - Stops all worker instances on the machines specified in the conf/workers file.
# sbin/stop-connect-server.sh - Stops all Spark Connect server instances on the machine the script is executed on.
# sbin/stop-all.sh - Stops both the master and the workers as described above.