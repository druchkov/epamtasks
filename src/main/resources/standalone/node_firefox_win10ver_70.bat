set STANDALON_VERSION=3.141.59
set NODE_PORT=5556
set HUB_PORT=4444
set IP=localhost
java -jar selenium-server-standalone-%STANDELON_VERSION%.jar -role webdriver -hub http://%IP%:%HUB_PORT%/grid/register -port %NODE_PORT% -browser browserName=firefox,version=70,maxInstances=5,platform=WIN10