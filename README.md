# HostnameByIP
<h2>Made by Thecrafterja</h2>
Written in Java

## What does it do?
This program converts a hostname like 'thecrafterja.github.io' into the correct ip address, like '136.153.12.12'(only example)

For example, this can be used, if you know, that your raspberrypi has the hostname 'raspi', but you don't know, which ip it has.


## How to use
Download the newest release. You will also need a jdk or jre. Minimum is jdk-16.<br>
Then you have to run:
```
java -jar HostnameToIP-1.0.1.jar <arguments>
```

## Arguments
With '-hn' you can insert a hostname. This can be done multiple times.
```
-hn thecrafterja.github.io
```

With '-f' you can insert a file with hostnames. Every new line is taken as a hostname.
```
-f domains.txt
```

<b>Disabled:</b>
With -cout you can activate or deactivate the console output. Activated output is default.
```
-cout false
```

## Developer information
-cout will be enabled when 'file-output' is available.

## Contribution, Issues...
This is my first public Github repository with a real project. This project isn't big, but it's a beginning. I am happy about every contribution, every reported issue and every look at this repository. Thanks!
