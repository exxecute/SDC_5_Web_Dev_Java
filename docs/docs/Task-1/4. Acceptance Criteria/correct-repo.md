---
sidebar_position: 2
---

# Correct repository is injected based on configuration

## Using Map

If using map repository -> get all will return 0 counts

```txt title="aplication.properties"
filepath.rates=classpath:rates.txt
repository.type=map
```

Then receives

![map](../../../assets/Task-1/map.png)

## Using File

If using file -> get all will return 2 counts, because in file by default we have 2 rows

```txt title="aplication.properties"
filepath.rates=classpath:rates.txt
repository.type=file
```

Then receives

![file](../../../assets/Task-1/file.png)

## Using Jdbc

If using jdbc -> get all will return an error, because it is not implemented soon

```txt title="aplication.properties"
filepath.rates=classpath:rates.txt
repository.type=jdbc
```

Then receives

![jdbc](../../../assets/Task-1/jdbc.png)
