./run.sh -f iotest/in1/ -i aentrada1MB -r 1000 2>in1a.txt

./run.sh -f iotest/in1/ -i aentrada10MB -r 1000 2>in1b.txt

./run.sh -f iotest/out1/ -o -r 1000 -a '-l 1000 -c 999' 2>out1a.txt

./run.sh -f iotest/out1/ -o -r 1000 2>out1b.txt

./run.sh -f iotest/out2/ -o -r 1000 -a '-l 1000 -c 999' 2>out2a.txt

./run.sh -f iotest/out2/ -o -r 1000 2>out2b.txt

./run.sh -f iotest/out3/ -o -r 1000 -a '-l 1000 -c 999' 2>out3a.txt

./run.sh -f iotest/out3/ -o -r 1000 2>out3b.txt

shutdown now
