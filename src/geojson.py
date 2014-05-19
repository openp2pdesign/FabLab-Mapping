# coding: utf-8
#
# Mapping FabLabs
# Convert the data from Fablabs.io to GeoJson
#
# Author: Massimo Menichinelli
# Homepage: http://www.openp2pdesign.org
# License: MIT
#
# Requisite: 
# install requests with pip install requests
# install json with pip install json
#

import requests
import json

# Load FabLab list
url = "https://api.fablabs.io/v0/labs.json"
fablab_list = requests.get(url).json()

# Print a beautified version of the FabLab list
print json.dumps(fablab_list, sort_keys=True, indent=4)

features = {}
features["type"] = "FeatureCollection"
features_list = []

for k,i in enumerate(fablab_list["labs"]):
	print "Name:", i["name"]
	print "Latitude:", i["latitude"]
	print "Logitude:", i["longitude"]
	print "Link:",i["url"]	
	print
	feature_dict = {}
	coord = []
	coord.append(i["longitude"])
	coord.append(i["latitude"])
	feature_dict["type"] = "Feature"
	feature_dict["properties"] = {}
	feature_dict["geometry"] = {}
	feature_dict["properties"]["name"] = i["name"]
	feature_dict["properties"]["link"] = i["url"]
	feature_dict["geometry"]["type"] = "Point"
	feature_dict["geometry"]["coordinates"] = coord
	if i["latitude"] and i["longitude"] != "null": 
		features_list.append(feature_dict)

features["features"] = features_list

print "Our GEOjson:"
print json.dumps(features, sort_keys=True, indent=4)

with open('data/data.json', 'w') as outfile:
	json.dump(features, outfile)