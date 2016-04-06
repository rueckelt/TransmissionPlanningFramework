
% 2015-10-17 01:04:07

% my_logs\longTest1\3_0_0\rep_16\priorityMatch_log.m
scheduling_duration_us = 12546;

% schedule
schedule_f_t_n(:,:,1) = [6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 2; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [18; 7; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 0; 4; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 5; 14; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 18; 18; 18; 18; 18; 18; 18; 18; 18; 18; 13; 13; 13; 13; 17; 7; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,5) = [0; 11; 14; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,6) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5];
schedule_f_t_n(:,:,7) = [0; 0; 0; 18; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 7; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,8) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 5; 13; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 1080, 0, 0, 0, 0];
vioDl = [0, 0, 0, 0, 0, 50, 196, 0];
vioNon = [0, 0, 0, 0, 0, 3150, 0, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 5, 5, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [1800, 0, 0, 224, 0, 0, 0, 0];
vioLcy = [31680, 0, 0, 0, 0, 15840, 0, 0];
vioJit = [19250, 0, 0, 0, 0, 11000, 0, 0];
cost_vio = 807444;
cost_switches = 0;
cost_ch = 6981;
costTotal = 814425;

% priorityMatch
% 
% ############### Network 0 ##############
% F0	|[0]6	|6	|6	|6	|6	|6	|6	|6	|6	|6	|[10]6	|6	|6	|6	|6	|6	|6	|6	|2	|	|[20]	|	|	|	|	|
% F1	|[0]18	|7	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|4	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|5	|[20]14	|	|	|	|	|
% F3	|[0]	|	|	|	|18	|18	|18	|18	|18	|18	|[10]18	|18	|18	|18	|13	|13	|13	|13	|17	|7	|[20]	|	|	|	|	|
% F4	|[0]	|11	|14	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F5	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|5	|5	|5	|5	|5	|5	|[20]5	|5	|5	|5	|5	|
% F6	|[0]	|	|	|18	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|7	|[20]	|	|	|	|	|
% F7	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]5	|13	|	|	|	|
