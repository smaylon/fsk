#!/bin/bash
# Smoll – 17/04/17 as 01h08m
echo Digite seu nome: 
if read -t6 nome
then
	echo “Olá $nome, deseja continuar? [s/n]
	read -n1 resposta
	case $resposta in 
		S|s) echo
			echo você escolheu continuar;;
		N|n) echo
			echo Operação interrompida;;
		*) echo
			echo Opção inválida, digite apenas s ou n;;
	esac
else
	echo “Voce demorou demais para resonpoder!”
fi
