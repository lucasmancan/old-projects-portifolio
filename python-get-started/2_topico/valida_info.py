#6 - Faça um programa que leia e valide as seguintes informações:
#Nome: maior que 3 caracteres;
#Idade: entre 0 e 100;
#Salário: maior que zero;
#Sexo: 'f' ou 'm';
#Estado Civil: 's', 'c', 'v', 'd';


def validate(function, value, input_message):
    while not function(value):
        print("Valor incorreto...")
        value = input(input_message)
    return value

nome = validate(lambda x : len(str(x)) > 3  ,input("Digite seu nome: "), "Digite seu nome: ")
idade = validate(lambda x : int(x) > 0 and int(x) <=  100 ,input("Digite sua idade: "), "Digite sua idade: ")
salario = validate(lambda x : float(x) > 0  ,input("Digite seu salario: "), "Digite seu salario: ")
sexo = validate(lambda x : str(x) == 'f' or  str(x) == 'm'   ,input("Digite seu sexo: "), "Digite seu sexo: ")
estado_civil = validate(lambda x : str(x) == 's' or  str(x) == 'c' or str(x) == 'v' or  str(x) == 'd'    ,input("Digite seu estado civil: "), "Digite seu estado civil: ")

print(nome)
print(idade)
print(salario)
print(sexo)
print(estado_civil)


