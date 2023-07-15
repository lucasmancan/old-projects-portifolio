
a = [0 for i in range(5)]

menorValor = 0

for i in range(5):
    a[i] = int(input("Digite um número: "))

menorValor = a[0]

for i in a:
    if i < menorValor:
        menorValor = i

print("Menor valor: "+ str(menorValor))   