set STANDELON_VERSION=3.141.59
set NODE_PORT=5557
set HUB_PORT=4444
set IP=localhost
set PATH_DRIVER =f:/drivers/operadriver.exe
java -Dwebdriver.chrome.driver=%PATH_DRIVER% -jar selenium-server-standalone-%STANDELON_VERSION%.jar -role webdriver -hub http://%IP%:%HUB_PORT%/grid/register -browser "browserName=opera,platform=WIN10,maxInstances=5" -port %NODE_PORT%