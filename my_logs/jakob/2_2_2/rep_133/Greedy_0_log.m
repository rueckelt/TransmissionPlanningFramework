
% 2016-10-14 11:45:15

% my_logs/jakob/2_2_2/rep_133/Greedy_0_log.m
scheduling_duration_us = 7824;

% schedule
schedule_f_t_n(:,:,1) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 4; 0, 0, 0, 23; 0, 0, 0, 23; 0, 0, 0, 23; 0, 0, 0, 23; 0, 0, 0, 4; 0, 64, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,3) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 0, 0, 15, 0; 0, 0, 15, 0; 0, 0, 15, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 15, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 15; 0, 0, 0, 15; 0, 0, 0, 15; 0, 0, 0, 15; 0, 0, 0, 15; 0, 0, 0, 15; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,4) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [0, 0, 2100, 6608];
vioDl = [0, 0, 300, 12390];
vioNon = [14904, 15840, 0, 93198];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 75, 70, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 65, 70, 71, 53, 30, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [602, 0, 20400, 0];
vioLcy = [0, 0, 6624, 0];
vioJit = [0, 0, 432, 0];
cost_vio = 1224488;
cost_switches = 5000;
cost_ch = 365310;
costTotal = 1594798;

% Greedy_0
% 
% ############### Network 0 ##############
% cap	|[0]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[10]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[20]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[30]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[40]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[50]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[60]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[70]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[80]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[90]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|15	|15	|15	|[40]15	|15	|15	|15	|15	|15	|	|	|	|15	|[50]15	|15	|15	|15	|15	|15	|15	|15	|15	|15	|[60]15	|15	|15	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|59	|59	|59	|59	|59	|59	|59	|[30]59	|59	|59	|59	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 1 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|64	|64	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|64	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 2 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|20	|20	|20	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|5	|5	|5	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|15	|15	|15	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 3 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|19	|38	|38	|[70]38	|38	|19	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|4	|23	|23	|[70]23	|23	|4	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|15	|15	|15	|[70]15	|15	|15	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|

