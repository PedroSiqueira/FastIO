./run.sh -f iotest/out4/ -o -r 1000 -e 2>out4a.txt

./run.sh -f iotest/out4/ -o -r 1000 -a '-l 2000 -c 999' -e 2>out4b.txt

./run.sh -f iotest/out5/ -o -r 1000 -e 2>out5a.txt

./run.sh -f iotest/out5/ -o -r 1000 -a '-l 2000 -c 999' -e 2>out5b.txt
