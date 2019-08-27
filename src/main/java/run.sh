folder="."
inputfile=""
outputfile=0
args=""
name=""
onlyecho=0

#se total de argumentos passados for zero
if [ $# = 0 ]; then
  echo 'usage: ./run.sh -i [input name] -o [there is output] -a [args between quotes] -f [folder location] -e [only echo]'
  exit
fi

#procura se possui os argumentos -i, -o, -a e -f (os que tem dois-pontos necessitam de um valor como parametro)
while getopts i:oa:f:e option
do
case "${option}"
  in
  i) inputfile=${OPTARG};;
  o) outputfile=1;;
  a) args=${OPTARG};;
  f) folder=${OPTARG};;
  e) onlyecho=1;;
esac
done

echo 'folder: '$folder
echo 'input file: '$inputfile
echo 'output file:'$outputfile
echo 'args: '$args
echo 'only echo: '$onlyecho
echo

for file in $folder/*.class; do
  #pega a substring a partir da ultima barra
  name="${file/*\//}"
  #descarta a extensao .class (ultimos 6 chars)
  name=">"${name:0:-6}".out"

  command='java '${file:0:-6}' '$args
  #se nao esta vazia
  if [ -n "$inputfile" ]; then
    command=$command' <'$inputfile
  fi
  if [ "$outputfile" = 1 ]; then
    command=$command' '$name
  fi
  echo $command

  if [ "$onlyecho" = 0 ]; then
    for run in {1..20}; do
      #executa comando dentro da string
      eval $command
    done
  fi
  echo
done

#limpa a tela e emite um beep
for run in {1..20}; do
  echo
  echo -ne '\007'
done

#toca uma musica
vlc /home/pedro/MEGA/Musics/Palankin/Palankin_-_Pulsante.mp3

