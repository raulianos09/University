
# A) Substitute the i-th elem from a list, with a value v;
#
# substitute(L1L2L3...Ln, v , i) =
# {
# 	[], n=0
# 	L1 U substitute(L2L3...Ln, v, i-1), i>1
# 	V U L2L3...Ln, i == 1
# }


def substitute(list, v, i):
    if len(list) == 0:
        return
    if i > 1:
        return [list[0]]+substitute(list[1:],v,i-1)
    if i == 1:
        return [v] + list[1:]
    return list

#B)Determine difference of two sets represented as lists.
#
#dfference(L1L2...Ln, l1l2...lm)=
#{
#	[],n=0
#   [],m=0
#	L1 U difference(L2L3...Ln , l1l2...lm),L1 not in l1l2...lm
#	difference(L2L3...Ln,l1l2...lm), otherwise
#
#}

def difference(listA,listB):
    if len(listA)==0 or len(listB) == 0:
        return []
    if listA[0] not in listB:
        return [listA[0]] + difference(listA[1:],listB)
    return difference(listA[1:],listB)

if __name__ == '__main__':
    A = [1, 2, 3]
    B = [1]
    print("Substitute: ", end = '' )
    print(substitute(B,1000,1))

    print("Difference: ", end = '')
    print(difference(B,A))

