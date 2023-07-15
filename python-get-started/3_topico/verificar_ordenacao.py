vetor = [0 for i in range(5)]

for i in range(5):
    print(i)
    vetor[i] = int(input("Digite um número: "))


vetorSorted = vetor.copy()
vetorSorted.sort()
vetorSortedInverse = vetor.copy()
vetorSortedInverse.sort(reverse=True)

if(vetor == vetorSorted):
    print(True)
else:
    print(False)

