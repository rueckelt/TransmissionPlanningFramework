
% 2015-10-17 01:04:18

% my_logs\longTest1\0_0_1\rep_1\priority_log.m
scheduling_duration_us = 2650;

% schedule
schedule_f_t_n(:,:,1) = [6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 0, 6; 0, 6; 0, 6; 0, 6; 0, 6; 0, 6; 0, 6; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 0, 0];

% cost function results
vioSt = [0];
vioDl = [0];
vioNon = [9234];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0];
vioLcy = [24990];
vioJit = [6480];
cost_vio = 366336;
cost_switches = 400;
cost_ch = 840;
costTotal = 367576;

% priority
% 
% ############### Network 0 ##############
% F0	|[0]6	|6	|6	|6	|6	|6	|6	|6	|6	|6	|[10]6	|6	|	|	|	|	|	|	|	|6	|[20]6	|6	|6	|6	|	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|6	|6	|6	|6	|6	|6	|6	|	|[20]	|	|	|	|	|
