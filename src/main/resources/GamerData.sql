create database sample_DB

create table GameInfo
(
    GameId       int PRIMARY KEY,
    GameName     varchar(255),
    Publisher    varchar(255),
    LaunchDate   varchar(255),
    version      varchar(255),
    Processor    varchar(255),
    Ram          varchar(255),
    GraphicsCard varchar(255)
)

create table Gamers
(
    ID           int PRIMARY KEY,
    FName        varchar(255),
    LName        varchar(255),
    EmailAddress varchar(255),
    Gender       varchar(255),
)

insert into GameInfo (GameId, GameName, Publisher, LaunchDate, version, Processor, Ram, GraphicsCard)
values (1,'GTA','Rockstar','September 17, 2013','3.1.6','i5','8gb','gtx 1060');

insert into GameInfo (GameId, GameName, Publisher, LaunchDate, version, Processor, Ram, GraphicsCard)
values (2,'Mario','SEGA','Jan 12, 1999','5','Ryzen','12gb','rtx 3090');

insert into Gamers(ID,FName,LName,EmailAddress,Gender)
values (1,'Hamza','Temuri','hamza.temuri@abc.com','Male')

insert into Gamers(ID,FName,LName,EmailAddress,Gender)
values (2,'Ali','Asad','ali.a@abc.com','Male')

select * from Gamers

select * from GameInfo

insert into Gamers(ID,FName,LName,EmailAddress,Gender)
values (3,'abdul','basit','basit@asd.com','male')

create table MappingGamers(
    GamerID int foreign key references Gamers(ID),
    GameID int foreign key references GameInfo(GameId),
    primary key (GamerID,GameID))

select * from MappingGamers;

insert into MappingGamers(GAMERID, GAMEID) values (1,1)

select * from GameInfo GI
full join MappingGamers MG on GI.GameId = MG.GameId

select ID, FName, LName, EmailAddress, Gender, GI.GameId, GI.GameName, GI.Publisher, GI.LaunchDate, GI.version, GI.Processor, GI.Ram, GI.GraphicsCard from Gamers G
    left join MappingGamers MG on (MG.GamerID = G.ID)
    left join GameInfo GI on (MG.GameId = GI.GameId)
where G.ID = 1

select ID as GamerId, GI.GameId, GI.GameName, GI.Publisher, GI.LaunchDate, GI.version, GI.Processor, GI.Ram, GI.GraphicsCard from Gamers G
inner join MappingGamers MG on (MG.GamerID = G.ID)
inner join GameInfo GI on (MG.GameId = GI.GameId)

insert into MappingGamers (GamerID, GameID)
values (6,1);

delete from Gamers
where ID = 3

delete from GameInfo
where GameId = 1

delete from MappingGamers
where GamerID = 6 and GameID = 1

insert into GameInfo (GameId)
values (5);

select * from GameInfo
where GameId =1

update Gamers
set FName = 'abc', LName = 'def', EmailAddress = 'abc@def.com', Gender = 'male'
where ID = 500

update GameInfo
set GameName=?, Publisher=?, LaunchDate=?, version=?, Processor=?, Ram=?, GraphicsCard=?
where GameId=?

update MappingGamers
set GameID = ?
where GamerID = ? and GameID = ?

