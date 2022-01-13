# HostnameToIP
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

With -cout you can activate or deactivate the console output. Activated output is default.
```
-cout false
```

With -outf you can set a file for the results.
```
-outf result.txt
```
The file looks like that:
```
thecrafterja.github.io
136.153.12.12
136.153.12.15
#
example.example
136.153.22.12
2001:0db8:85a3:0000:0000:8a2e:0370:7334
#
```
```
<hostname>
<ip-address 1>
<ip-address 2>
<line seperator: #>
```

## Developer information
-- NOTHING --

## Contribution, Issues...
This is my first public Github repository with a real project. This project isn't big, but it's a beginning. I am happy about every contribution, every reported issue and every look at this repository. Thanks!
