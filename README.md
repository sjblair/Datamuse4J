# Datamuse4J
First, please note I am not affiliated with OneLook or Datamuse in any way. I just like the service and decided to implement some Java code to allow easy access to the API.
Datamuse4J is a handler for calling the Datamuse RESTful API. Some background information on Datamuse:

> The Datamuse API is an English word-finding tool for developers.
>
> The API enables programmatic access to the core lookup used by the [OneLook reverse dictionary](http://onelook.com/reverse-dictionary.shtml), as well as “sounds like” and “spelled like” functions. Constraints on meaning, spelling, and sound can be specified as unrestricted character strings, and any intersection of the constraints can be computed.

All the available RESTful API calls have been implemented here for Java. If I have forgot to cover something you can probably fix it pretty easily yourself.
The endpoints used by Datamuse are `api.datamuse.com/words` and `api.datamuse.com/words`; these can handle both HTTP and HTTPS requests.
Currently there is no rate limiting or API keys needed for the API but it is experimental and may be rate limited at no notice. If you need guarentees about availablity, message [OneLook here](http://onelook.com/about.shtml#feedback) and they can set you up.

Here is a brief summary of what this code can do:
**GET** `/words{?rd,sl,sp,max}`
**rd** `.findSimilar` “Reverse dictionary” constraint: show terms that have a meaning similar to this concept, which may be any word or sequence of words.
**sl** `.soundsSimilar` “Sounds like” constraint: show terms that are pronounced similarly to this string of characters.
**sp** `.speltSimilar` “Spelled like” constraint: shows terms that are spelled similarly to this string of characters, or that match this wildcard pattern.

**GET** `/sug{?s,max}`
**s** `.prefixHintSuggestions` Prefix hint string; typically, the characters that the user has entered so far into a search box. (Note: The results are sorted by popularity and may include spell-corrections of the prefix hint. That is to say, the prefix hint will not necessarily form a prefix of each result.)
