set STANDELON_VERSION=3.141.59
set NODE_PORT=5555
set HUB_PORT=4444
set IP=localhost
set PATH_DRIVER=f:/drivers/chromedriver.exe
java -Dwebdriver.chrome.driver=%PATH_DRIVER% -jar selenium-server-standalone-%STANDELON_VERSION%.jar -role node -hub http://%IP%:%HUB_PORT%/grid/register -port %NODE_PORT% -browser browserName=chrome,version=78,platform=WIN10,maxInstances=5