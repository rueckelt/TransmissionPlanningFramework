
% 2015-10-17 01:04:37

% my_logs\longTest1\2_0_1\rep_4\priorityMatch_log.m
scheduling_duration_us = 6833;

% schedule
schedule_f_t_n(:,:,1) = [5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,2) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 16; 0, 9; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,3) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 12; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,4) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 60; 0, 60; 0, 38; 0, 16; 15, 0; 15, 0; 15, 0; 15, 0; 15, 0; 20, 0; 20, 0; 20, 0; 20, 0; 20, 0];

% cost function results
vioSt = [0, 0, 0, 4487];
vioDl = [0, 63, 0, 180];
vioNon = [0, 0, 0, 4025];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0, 0, 0, 0];
vioLcy = [14800, 0, 0, 0];
vioJit = [7500, 0, 0, 0];
cost_vio = 267027;
cost_switches = 600;
cost_ch = 3069;
costTotal = 270696;

% priorityMatch
% 
% ############### Network 0 ##############
% F0	|[0]5	|5	|5	|5	|5	|	|	|	|	|	|[10]	|	|	|	|	|5	|5	|5	|5	|5	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|15	|15	|15	|15	|15	|[20]20	|20	|20	|20	|20	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|	|	|5	|5	|5	|5	|5	|[10]5	|5	|5	|5	|5	|	|	|	|	|	|[20]	|	|	|	|	|
% F1	|[0]	|	|	|	|	|16	|9	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|12	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|60	|60	|38	|16	|	|	|	|	|	|[20]	|	|	|	|	|
