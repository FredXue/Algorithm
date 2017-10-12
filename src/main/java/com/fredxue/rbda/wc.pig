lines = LOAD 'workspace/input/wc_input.txt' AS (line:chararray);
keywords = LOAD 'workspace/input/keywords.txt' AS (keyword:chararray);
words = FOREACH lines GENERATE line, FLATTEN(TOKENIZE(LOWER(line), ' :;#-,')) as word;
distinct_words = DISTINCT words;
grouped = GROUP distinct_words BY word;
wordcount = FOREACH grouped GENERATE group, COUNT($1);
temps = JOIN keywords BY LOWER($0) LEFT, wordcount BY $0;
result = FOREACH temps GENERATE keyword,  ($2 is not null ? $2 : 0) as count;
STORE result INTO 'pig_output';