#!/usr/bin/env zsh

# cd to the location of the script
SCRIPTPATH="$( cd "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"
cd $SCRIPTPATH

echo "Building..."
buildresult=$(mvn clean package -DskipTests=true)
if [[ "$buildresult" != *"BUILD SUCCESS"* ]]
then
  echo "Build verified - NOT OK"
  echo $buildresult
  exit 1
fi

echo "Testing..."
testresult=$(mvn test)
if [[ $testresult != *"Tests run: 1, Failures: 1, Errors: 0, Skipped: 0"* ]]
then
  mvn clean > /dev/null
  echo "Tests verified - NOT OK"
  echo $testresult
  exit 1
fi

# Clean temp files
mvn clean > /dev/null

# cd back to where we came from
cd - > /dev/null

echo "Installation, building and testing verified - OK"
exit 0