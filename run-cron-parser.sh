#!/bin/bash

# Compile and package your application
mvn clean package

# Check if Maven build was successful
if [ $? -ne 0 ]; then
    echo "Error: Maven build failed."
    exit 1
fi

# Run your application with an argument
java -cp target/classes/ org.deliveroo.Main "$1"