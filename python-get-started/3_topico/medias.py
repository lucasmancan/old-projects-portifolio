#6 - Ler do teclado a idade e o sexo de 10 pessoas calculem e imprimam:
#Idade média das mulheres
#Idade média dos homens
#Idade média do grupo

class Pessoa:
    def __init__(self, idade, sexo):
        self.idade = idade
        self.sexo = sexo


lista = [0 for i in range(2)]

for i in range(2):
    idade = int(input("Digite a idade:"))
    sexo = input("Digite o sexo (M - Masculino, F - Feminino):")
    lista[i] = Pessoa(idade, sexo)

sumIdadeMulheres = 0
sumIdadeHomens = 0

for i in filter(lambda pessoa: pessoa.sexo == 'F', lista):
    sumIdadeMulheres += i.idade

for i in filter(lambda pessoa: pessoa.sexo == 'M', lista):
    sumIdadeHomens += i.idade

listM = list(filter(lambda pessoa: pessoa.sexo == 'M', lista))
listF = list(filter(lambda pessoa: pessoa.sexo == 'F', lista))

print("Media mulheres: "+  str( sumIdadeMulheres / len(listF)))
print("Media homens: "+  str( sumIdadeHomens / len(listM))) 
print("Media grupo: "+  str( (sumIdadeHomens + sumIdadeMulheres) / len(lista))) 


