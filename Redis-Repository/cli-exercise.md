127.0.0.1:6379> set profile:42:name Mahmud
OK
127.0.0.1:6379> get profile:42:name
"Mahmud"
127.0.0.1:6379> hset profile:43 name sara city busan
(integer) 2
127.0.0.1:6379> get profile:43
(error) WRONGTYPE Operation against a key holding the wrong kind of value
127.0.0.1:6379> hset profile:43 name sara city busan 
(integer) 0
127.0.0.1:6379> get profile:43
(error) WRONGTYPE Operation against a key holding the wrong kind of value
127.0.0.1:6379> hset profile:43 name sara city busan 
(integer) 0
127.0.0.1:6379> HSET  profile:43 name sara city busan  
(integer) 0
127.0.0.1:6379> HSET profile:43 name sara city busan  
(integer) 0
127.0.0.1:6379> get profile:42:name
"Mahmud"
127.0.0.1:6379> HSET profile:43 name sara city busan
(integer) 0
127.0.0.1:6379> hget profile:43
(error) ERR wrong number of arguments for 'hget' command
127.0.0.1:6379> help
redis-cli 8.8.1
To get help about Redis commands type:
      "help @<group>" to get a list of commands in <group>
      "help <command>" for help on <command>
      "help <tab>" to get a list of possible help topics
      "quit" to exit

To set redis-cli preferences:
      ":set hints" enable online hints
      ":set nohints" disable online hints
Set your preferences in ~/.redisclirc
127.0.0.1:6379> help <get>

127.0.0.1:6379> TYPE profile:43
hash
127.0.0.1:6379> DEL profile:43
(integer) 1
127.0.0.1:6379> HSET profile:43 name sara city busan
(integer) 2
127.0.0.1:6379> HGETALL profile:43
1) "name"
2) "sara"
3) "city"
4) "busan"
127.0.0.1:6379> HGET profile:43 name
"sara"
127.0.0.1:6379> exists profile:42:name profile:43 profile:99
(integer) 2
127.0.0.1:6379> exists profile:42:name profile:4 profile:99
(integer) 1
127.0.0.1:6379> exists profile:42:name profile:43 
(integer) 2
127.0.0.1:6379> type profile:42:name
string
127.0.0.1:6379> type profile:43
hash
127.0.0.1:6379> del profile:42:name
(integer) 1
127.0.0.1:6379> get profile:42:name
(nil)
127.0.0.1:6379> EXISTS profile:42:name profile:43
(integer) 1
127.0.0.1:6379> 
