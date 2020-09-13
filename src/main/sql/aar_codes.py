# Open a file
fo = open("aar_codes.txt", "r+")
print ("Name of the file: ", fo.name)
tot_out = 0
for line in fo:
   if len(line) > 1:
   	   line = line.rstrip('\r\n')
   	   bob = line.split(" - ")
   	   if (len(bob[0]) <=2):
   	   	    if (len(bob[0]) ==2) and ((bob[0][1] >='0') and (bob[0][1] <= '9')):
   	   	    	continue
   	   	    print ("('{}','{}'),".format(bob[0], bob[1]))


#   	   	    print (bob[0][1])
   	   	    tot_out += 1

print(tot_out)
# Close opened file
fo.close()
