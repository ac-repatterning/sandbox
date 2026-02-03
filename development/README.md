<br>

### Remote Development

Images and containers:

```bash
docker build . --file .devcontainer/Dockerfile -t sandbox

docker run --rm -i -t -p 4040:4040 -p 8080:8080 -p 8081:8081 \
	-w /root --mount type=bind,src="$(pwd)",target=/root \
		-v ~/.aws:/root/.aws sandbox
```

<br>

Cleaning up:

```bash
cat /dev/null > ~/.bash_history && history -c
cat /dev/null > ~/.scala_history && history -c
```

<br>
<br>

### Apache Spark Interface

```bash
spark-class org.apache.spark.deploy.master.Master
spark-class org.apache.spark.deploy.worker.Worker spark://
```

<br>
<br>

<br>
<br>

<br>
<br>

<br>
<br>
