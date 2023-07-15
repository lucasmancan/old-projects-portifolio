 #Desenvolva um gerador de tabuada, capaz de gerar a tabuada de qualquer número inteiro entre 1 a 10. 
 #O usuário deve informar de qual numero ele deseja ver a tabuada. A saída deve ser conforme o exemplo abaixo

num = int(input("Digite um número inteiro entre 1 e 10: "))
aux = 1

while num < 0 or num > 10:
    num = int(input("Digite um número inteiro entre 1 e 10:"))
     
print("Tabuada do "+ str(num) + ": ")

while aux <= 10:
    print(str(num) + " x "+ str(aux) + ": " + str(num * aux))
    aux +=1
