./run.sh -f iotest/in1/ -e -i aentrada1MB -r 10 2>in1a.txt

./run.sh -f iotest/in1/ -e -i aentrada10MB -r 10 2>in1b.txt

./run.sh -f iotest/out1/ -e -o -r 10 -a '-l 1000 -c 999' 2>out1a.txt

./run.sh -f iotest/out1/ -e -o -r 10 2>out1b.txt

./run.sh -f iotest/out2/ -e -o -r 10 -a '-l 1000 -c 999' 2>out2a.txt

./run.sh -f iotest/out2/ -e -o -r 10 2>out2b.txt

./run.sh -f iotest/out3/ -e -o -r 10 -a '-l 1000 -c 999' 2>out3a.txt

./run.sh -f iotest/out3/ -e -o -r 10 2>out3b.txt
