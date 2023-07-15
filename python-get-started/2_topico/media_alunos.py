#Faça um programa que calcule o número médio de alunos por turma. Para isto, peça a quantidade 
#de turmas e a quantidade de alunos para cada turma. As turmas não podem ter mais de 40 alunos.

qt_turmas = int(input("Quantidade de turmas: "))
qt_alunos = 0;

aux = 1;

while aux <= qt_turmas:
    input_alunos = int(input("Digite a quantidade de alunos para a turma "+ str(aux) +": "))

    while input_alunos < 0 or input_alunos > 40:
        print("Quantidade de alunos não pode ser superior a 40 ou menor que 0 por turma. Digite outro valor...")
        input_alunos = int(input("Digite a quantidade de alunos para a turma "+ str(aux) +": "))

    aux += 1
    qt_alunos += input_alunos



print("A Média de alunos é "+ str(qt_alunos / qt_turmas))