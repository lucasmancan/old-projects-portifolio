
first_number = int(input("Digite o primeiro número: "))
second_number = int(input("Digite o segundo número: "))

sum = 0;
from_number = 0;
to_number = 0;


if(first_number > second_number):
    from_number = second_number
    to_number = first_number
else:
    from_number = first_number
    to_number = second_number


while (from_number <= to_number):
    if(from_number % 2 == 0):
        sum += from_number

    from_number +=1

print("A soma entre os números pares é: "+ str(sum))