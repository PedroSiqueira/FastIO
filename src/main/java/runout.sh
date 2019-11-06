./run.sh -f iotest/out4/ -o -r 100 2>out4a.txt

./run.sh -f iotest/out4/ -o -r 100 -a '-l 2000 -c 999' 2>out4b.txt

./run.sh -f iotest/out5/ -o -r 100 2>out5a.txt

./run.sh -f iotest/out5/ -o -r 100 -a '-l 2000 -c 999' 2>out5b.txt

shutdown now
