
% 2015-10-17 01:04:00

% my_logs\longTest1\3_0_0\rep_7\priorityMatch_log.m
scheduling_duration_us = 11810;

% schedule
schedule_f_t_n(:,:,1) = [5; 5; 0; 0; 0; 0; 0; 0; 0; 0; 0; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 0; 0; 0];
schedule_f_t_n(:,:,2) = [25; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 8; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 9; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 34; 34; 34; 34; 34; 34; 34; 34; 34; 18; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,5) = [4; 21; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,6) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5];
schedule_f_t_n(:,:,7) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 11; 14; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,8) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 6; 13; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 3094, 0, 0, 0, 0];
vioDl = [250, 0, 0, 0, 0, 50, 0, 0];
vioNon = [3150, 0, 0, 0, 0, 1750, 0, 0];
vioTpMin = [0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 150, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [4500, 0, 0, 900, 0, 0, 0, 0];
vioLcy = [13000, 0, 0, 0, 0, 8250, 0, 0];
vioJit = [2925, 0, 0, 0, 0, 2970, 0, 0];
cost_vio = 404396;
cost_switches = 0;
cost_ch = 7215;
costTotal = 411611;

% priorityMatch
% 
% ############### Network 0 ##############
% F0	|[0]5	|5	|	|	|	|	|	|	|	|	|[10]	|5	|5	|5	|5	|5	|5	|5	|5	|5	|[20]5	|5	|	|	|	|
% F1	|[0]25	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|8	|	|	|	|	|	|	|	|	|[10]	|	|9	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|34	|34	|34	|34	|34	|34	|34	|34	|[10]34	|18	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F4	|[0]4	|21	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F5	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|5	|5	|5	|5	|5	|5	|[20]5	|5	|5	|5	|5	|
% F6	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|11	|14	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F7	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|6	|13	|	|	|	|	|	|	|[20]	|	|	|	|	|
