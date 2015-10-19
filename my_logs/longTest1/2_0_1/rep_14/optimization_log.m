
% 2015-10-17 01:04:43

% my_logs\longTest1\2_0_1\rep_14\optimization_log.m
scheduling_duration_us = 180284;

% schedule
schedule_f_t_n(:,:,1) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 4; 0, 4; 0, 4; 0, 4; 0, 4; 0, 4; 0, 4; 0, 4; 0, 4; 0, 4; 0, 4; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,2) = [0, 0; 0, 0; 0, 0; 0, 0; 25, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,3) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 13; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,4) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 29, 0; 29, 0; 29, 0; 29, 0; 29, 0; 29, 0; 29, 0; 29, 0; 29, 0; 29, 0];

% cost function results
vioSt = [0, 0, 0, 725];
vioDl = [0, 0, 0, 145];
vioNon = [3960, 0, 0, 350];
vioTpMin = [4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [4000, 0, 0, 0];
vioLcy = [0, 0, 0, 0];
vioJit = [4928, 0, 0, 0];
cost_vio = 147868;
cost_switches = 0;
cost_ch = 3636;
costTotal = 151504;

% optimization
% 
% ############### Network 0 ##############
% F1	|[0]	|	|	|	|25	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|29	|29	|29	|29	|29	|[20]29	|29	|29	|29	|29	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|	|	|	|4	|4	|4	|4	|[10]4	|4	|4	|4	|4	|4	|4	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|13	|	|	|	|	|[20]	|	|	|	|	|
