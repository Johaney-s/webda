#!/usr/bin/python

import psycopg
import sys
from psycopg import Error

from general_parser import parse_file


def read_db_credentials():
    """ Returns [username, password] from /etc/webda/db.config file """
    config_filename = "/etc/webda/db.config"
    try:
        db_config = parse_file(config_filename, False)
        return [db_config[0][1], db_config[1][1]]
    except FileNotFoundError:
        sys.exit("Missing DB credentials file " + config_filename + "!")


def try_connect_to_database():
    credentials = read_db_credentials()
    try:
        # Connect to an existing database
        connection = psycopg.connect(user=credentials[0],
                                     password=credentials[1],
                                     host="127.0.0.1",
                                     port="5432",
                                     dbname="webda")

        # Create a cursor to perform database operations
        cursor = connection.cursor()
        # Executing a SQL query
        cursor.execute("SELECT version();")
        # Fetch result
        record = cursor.fetchone()
        print("You are connected to - ", record, "\n")

    except (Exception, Error) as error:
        print("Error while connecting to PostgreSQL", error)
    finally:
        if (connection):
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed")


print(try_connect_to_database())
