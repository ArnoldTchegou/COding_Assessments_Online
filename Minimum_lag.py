def minimumLag(centers, datacenters):
    centers.sort()
    datacenters.sort()
    res = 0
    for i in range(len(centers)):
        res+= abs(centers[i]-datacenters[i])
    return res
def getMaxsimi(list1, list2):
    n = len(list1)
    # Calculate initial similarity without any swaps
    max_simi = sum(1 for k in range(n) if list1[k] == list2[k])
    
    # Iterate through each pair of indices to consider swaps
    for i in range(n):
        for j in range(i + 1, n):
            # Swap elements at positions i and j
            list1[i], list1[j] = list1[j], list1[i]
            
            # Calculate similarity after the swap
            current_simi = sum(1 for k in range(n) if list1[k] == list2[k])
            
            # Update max_simi if current_simi is greater
            max_simi = max(max_simi, current_simi)
            
            # Swap back to original positions
            list1[i], list1[j] = list1[j], list1[i]
    
    return max_simi

def getMaximumSimilarities(inv1, inv2):
    n = len(inv1)
    # If the inventories are identical, return full length as maximum similarity
    if inv1 == inv2:
        return n
    if sum(inv1) == sum(inv2):
        return n-1
    return getMaxsimi(inv1, inv2)

# Example usage
print(getMaximumSimilarities([3, 0, 2], [6, 3, 2])) 


#print(minimumLag([3, 1, 6, 8, 9], [2, 3, 1, 7, 9]))