
a = [0 for i in range(10)]
qt_in_range = 0

for i in range(10):
    a[i] = int(input("Digite um número: "))
    
    if a[i] >= 10 and a[i] <= 50:
        qt_in_range +=1


print("A quantidade de elementos entre 10 e 50 é: "+str(qt_in_range))