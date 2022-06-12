import csv


def parse_file(filename, only_headers):
    """ Parse single file into array of values """
    records = []

    with open(filename, 'r') as file:
        csv_reader = csv.reader(file, delimiter='\t')
        line_count = 0
        for row in csv_reader:
            if line_count == 0 or (line_count == 1 and row[0].startswith("--")):
                if only_headers:
                    return row
            else:
                records.append(row)
            line_count += 1

    return records